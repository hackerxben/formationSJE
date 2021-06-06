import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { AuthRequest } from "../models/AuthRequest";
import { AuthResponse } from "../models/AuthResponse";

@Injectable({
    providedIn: 'root',
  })
export class LoginService{

    headers = { 'Content-type': 'text/html'};

    constructor(
        private httpclient: HttpClient
    ){

    }

    public authenticate(authRequest: AuthRequest):Observable<AuthResponse>{
        return this.httpclient.post<AuthResponse>("http://localhost:8080/authenticate",authRequest)
    }

    public getToken():string{
        return localStorage.getItem("token")!
    }
}