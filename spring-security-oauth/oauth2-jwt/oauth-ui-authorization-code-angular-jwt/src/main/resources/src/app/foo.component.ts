import {Component} from '@angular/core';
import {AppService, Foo} from './app.service'

@Component({
  selector: 'foo-details',
  providers: [AppService],
  template: `
    <div class="container">
      <h1 class="col-sm-12">Foo Details</h1>
      <li *ngFor="let foo of foos">
        <div class="col-sm-12">
          <label class="col-sm-3">ID</label> <span>{{foo.id}}</span>
        </div>
        <div class="col-sm-12">
          <label class="col-sm-3">Name</label> <span>{{foo.name}}</span>
        </div>
      </li>
    </div>`
})

export class FooComponent {
  private foosUrl = 'http://localhost:8081/jwt-resource-server/api/foos/';
  public foos = new Array();

  constructor(private _service: AppService) {
  }

  ngOnInit() {
    this._service.getResource(this.foosUrl)
      .subscribe(
        data => this.foos = data,
        error => console.log('Error get list foos'));
  }

}
