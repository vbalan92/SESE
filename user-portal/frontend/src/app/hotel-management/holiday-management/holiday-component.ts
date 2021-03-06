import {
  Component,
  ChangeDetectionStrategy,
  ViewChild,
  TemplateRef, OnInit
} from '@angular/core';
import {
  startOfDay,
  endOfDay,
  subDays,
  addDays,
  endOfMonth,
  isSameDay,
  isSameMonth,
  addHours
} from 'date-fns';
import {Subject} from 'rxjs';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {
  CalendarEvent,
  CalendarEventAction,
  CalendarEventTimesChangedEvent,
  CalendarView
} from 'angular-calendar';
import {EventService} from '../../services/event.service';
import {EventDTO} from './models/event-dto';
import {DatePipe} from '@angular/common';
import {TokenStorageService} from '../../auth/token-storage.service';

const colors: any = {
  red: {
    primary: '#ad2121',
    secondary: '#FAE3E3'
  },
  blue: {
    primary: '#1e90ff',
    secondary: '#D1E8FF'
  },
  yellow: {
    primary: '#e3bc08',
    secondary: '#FDF1BA'
  }
};

@Component({
  selector: 'app-holiday-component',
  changeDetection: ChangeDetectionStrategy.OnPush,
  styleUrls: ['styles.css'],
  templateUrl: 'holiday-add.html'
})
export class HolidayComponent implements OnInit {
  @ViewChild('modalContent')
  modalContent: TemplateRef<any>;

  view: CalendarView = CalendarView.Month;

  CalendarView = CalendarView;

  viewDate: Date = new Date();

  eventDTO: EventDTO = new EventDTO();

  modalData: {
    action: string;
    event: CalendarEvent;
  };

  actions: CalendarEventAction[] = [
    {
      label: '<i class="fa fa-fw fa-pencil"></i>',
      onClick: ({event}: { event: CalendarEvent }): void => {
        this.handleEvent('Edited', event);
      }
    },
    {
      label: '<i class="fa fa-fw fa-times"></i>',
      onClick: ({event}: { event: CalendarEvent }): void => {
        this.events = this.events.filter(iEvent => iEvent !== event);
        this.handleEvent('Deleted', event);
      }
    }
  ];

  refresh: Subject<any> = new Subject();


  events: CalendarEvent[] = [
    {
      start: subDays(startOfDay(new Date()), 1),
      end: addDays(new Date(), 1),
      title: 'Dummy Holiday Request',
      color: colors.red,
      actions: this.actions,
      allDay: true,
      resizable: {
        beforeStart: true,
        afterEnd: true
      },
      draggable: true
    }];

  activeDayIsOpen: Boolean = true;

  constructor(private modal: NgbModal,
              private  service: EventService,
              private datepipe: DatePipe,
              private tokenStorage: TokenStorageService) {
  }

  createNew(): EventDTO {
    this.eventDTO.from = subDays(startOfDay(new Date()), 1);
    this.eventDTO.to = addDays(new Date(), 1);
    this.eventDTO.eventName = 'New Holiday Request';
    this.eventDTO.username = this.tokenStorage.getUsername();
    this.refresh.next();
    return this.eventDTO;
  }

  ngOnInit() {
    this.service.findAll().subscribe(
      (founds: EventDTO[]) => {
        founds.forEach((element) => {
          this.addEvent(element);
        });
      }
    );
  }

  dayClicked({date, events}: { date: Date; events: CalendarEvent[] }): void {
    if (isSameMonth(date, this.viewDate)) {
      this.viewDate = date;
      if (
        (isSameDay(this.viewDate, date) && this.activeDayIsOpen === true) ||
        events.length === 0
      ) {
        this.activeDayIsOpen = false;
      } else {
        this.activeDayIsOpen = true;
      }
    }
  }

  eventTimesChanged({
                      event,
                      newStart,
                      newEnd
                    }: CalendarEventTimesChangedEvent): void {
    event.start = newStart;
    event.end = newEnd;
    this.handleEvent('Dropped or resized', event);
    this.refresh.next();
  }

  handleEvent(action: string, event: CalendarEvent): void {
    this.modalData = {event, action};
    this.modal.open(this.modalContent, {size: 'lg'});
  }

  addEvent(eventDTO: EventDTO): void {
    this.events.push({
      title: eventDTO.eventName + ' :: ' + eventDTO.username,
      start: new Date(eventDTO.from),
      end: new Date(eventDTO.to),
      color: colors.red,
      id: eventDTO.id,
      draggable: eventDTO.username === this.tokenStorage.getUsername(),
      resizable: {
        beforeStart: true,
        afterEnd: true
      }
    });
    this.refresh.next();
  }

  save(event): void {
    this.eventDTO.from =  new Date(this.getDateInMillis(event.start));
    this.eventDTO.to =  new Date(this.getDateInMillis(event.end));
    this.eventDTO.eventName = event.title;
    this.eventDTO.userId = 1;
    this.eventDTO.username = this.tokenStorage.getUsername();
    this.eventDTO.name = this.tokenStorage.getUsername();
    this.eventDTO.email = 'user@user.com';
    this.service.createHoliday(this.eventDTO).subscribe(
      (created: EventDTO) => {
        console.log('created event:: ' + created.id);
      }
    );
    this.refresh.next();
  }

  private getDateInMillis(date: any) {
    let date2 = new Date(Date.UTC(date.year, date.month - 1, date.day));
    return date2.getTime();
  }

  delete(event): void {
    this.eventDTO.from = new Date(this.getDateInMillis(event.start));
    this.eventDTO.to = new Date(this.getDateInMillis(event.end));
    this.eventDTO.eventName = event.title;
    this.eventDTO.id = event.id;
    this.service.deleteHoliday(this.eventDTO).subscribe(
      (deleted: EventDTO) => {
        console.log('deleted event:: ' + deleted.id);
      }
    );
  }
}
