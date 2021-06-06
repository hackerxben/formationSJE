import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { AuthRequest } from '../models/AuthRequest';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(
    private fb : FormBuilder,
    private loginService: LoginService
  ) { }

  loginForm = this.fb.group(
    {
      login: [""],
      password: [""]
    }
  )
  ngOnInit(): void {
  }

  login(): void{
    let authRequest = new AuthRequest()
    console.log("login: " +this.loginForm.get("login")!.value)
    console.log("password: " +this.loginForm.get("password")!.value)
    authRequest.login = this.loginForm.get("login")!.value
    authRequest.password = this.loginForm.get("password")!.value
    this.loginService.authenticate(authRequest).subscribe(
      (authResponse) => {
        console.log("AuthResponse: "+JSON.stringify(authResponse))
        localStorage.setItem("token",authResponse.token!)
      }
      
    )
  }

}
