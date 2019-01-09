import { Component, OnInit } from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import { TodoServiceService } from './todo-service.service';

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
  message=false;
  resmessage='';
  constructor(private todo:TodoServiceService){}

  ngOnInit()
  {
    this.todo.fetchTask().subscribe(res=>{
      if(res.responseCode==1000)
      {
        this.toDos=res.responseData;
        console.log("data",this.toDos);
        console.log("resp",res);
      }
      else
        console.log("error");
    })
  }

  createToDo()
  {
    this.create=true;
    this.createTask=new FormControl('');
    this.remove=false;
    this.message=false;
    this.resmessage="";
    this.done=false;
  }

  saveTask()
  {
    this.message=false;
    this.resmessage="";
    console.log("create",this.createTask);
    if(this.createTask.value!="")
    {
      const todo={id:'',
      task:this.createTask.value,
      status:"Not Done"}
      this.todo.createTask(todo).subscribe(res=>{
        if(res.responseCode==1000)
        {
          this.message=true;
          this.resmessage="CREATED SUCCESSFULLY!";
          this.toDos.push(todo);
        }
        else
        {
          this.message=true;
          this.resmessage="SOME INTERNAL PROBLEM!";
        }
      })
    this.create=false;
    }
    console.log("todo",this.toDos)
  }
remove=false;
  removeToDo()
  {
    this.message=false;
    this.resmessage="";
    this.remove=true;
    this.create=false;
    this.done=false;

  }
  removeTask(todo)
  {
    const del={id:todo.id}
    this.todo.deleteTask(del).subscribe(res=>{
      if(res.responseCode==1000)
      {
        const index=this.toDos.findIndex(a=>a.id==todo.id)
        this.toDos.splice(index,1);
        // this.message=true;
        // this.resmessage="CREATED SUCCESSFULLY!";
        // this.toDos.push(todo);
      }
      else
      {
        this.message=true;
        this.resmessage="SOME INTERNAL PROBLEM!";
      }
    })
  }
done=false;
doneToDo()
{
  this.done=true;
  this.message=false;
  this.resmessage="";
  this.remove=false;
  this.create=false;

}
  doneTask(todo)
  {
    const update={id:todo.id,status:"DONE"}
    this.todo.updateTask(update).subscribe(res=>{
      if(res.responseCode==1000)
      {
        this.toDos.filter(a=>{
          if(a.id==todo.id)
            {a.status="DONE";}
        });
      }
      else
      {
        this.message=true;
        this.resmessage="SOME INTERNAL PROBLEM!";
      }
    })
  }
}
