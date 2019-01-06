import { Component, OnInit } from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
// import { create } from 'domain';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'Todo App';
  toDos;
  create=false;
  createTask;
  constructor(){}

  ngOnInit()
  {
    this.toDos=[
      {task:'Learn Angular',
      id:1,
      status:'DONE'},
      {task:'Learn Node',
      id:2,
      status:'DONE'},
      {task: 'Learn Spring',
        id:3,
        status:'NOT DONE'}];
  }

  createToDo()
  {
    this.create=true;
    this.createTask=new FormControl('');
  }

  saveTask()
  {
    console.log("create",this.createTask);
    if(this.createTask.value!="")
    {
    this.toDos.push(this.createTask.value);
    this.create=false;
    }
    console.log("todo",this.toDos)
  }
remove=false;
  removeToDo()
  {
    this.remove=true;
    this.remaintodos=this.toDos;
  }
  remaintodos;
  removeTask(todo)
  {
    
    this.remaintodos=this.arrayRemove(this.toDos,todo);
  }
  arrayRemove(arr, value) {
    return arr.filter(function(ele){
        return ele != value;
    });
  }
  saveRemainToDo()
  {
    this.toDos=[];
    this.toDos=this.remaintodos;
    this.remove=false;
  }
}
