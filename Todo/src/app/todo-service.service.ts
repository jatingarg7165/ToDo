import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TodoServiceService {
  domain = environment.domain;
  constructor(private http:HttpClient) { }

  fetchTask():Observable<any>{

    return this.http.get(this.domain+"/fetchTask");
  }
}

