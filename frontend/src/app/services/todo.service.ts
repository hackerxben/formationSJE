import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Todo } from "../models/Todo";

@Injectable({
    providedIn: 'root',
  })
export class TodoService{
    constructor(
        private httpclient: HttpClient
    ){}

    public getAllTodos(): Observable<Todo[]>{
        return this.httpclient.get<Todo[]>("http://localhost:8080/getAllTodos");
    }
}