import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { NavComponent } from './nav/nav.component';
/*import { GradesComponent } from './grades/grades.component';
import { PastQuizzesComponent } from './past-quizzes/past-quizzes.component';
import { CurrentQuizzesComponent } from './current-quizzes/current-quizzes.component';*/
import { TakeQuizComponent } from './take-quiz/take-quiz.component';
import { AppRoutingModule, componentRoutes } from './app-routing.module';
import { FormsModule }    from '@angular/forms';
import { HttpClientInMemoryWebApiModule } from 'angular-in-memory-web-api';
import { HttpClientModule } from '@angular/common/http';
import { availableUsers } from './models/availableUsers';
import { RegisterUserComponent } from './register-user/register-user.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    NavComponent,
    componentRoutes,
    TakeQuizComponent,
    RegisterUserComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,

    // The HttpClientInMemoryWebApiModule module intercepts HTTP requests
    // and returns simulated server responses.
    // Remove it when a real server is ready to receive requests.
    HttpClientInMemoryWebApiModule.forRoot(
      availableUsers, { dataEncapsulation: false }
    )
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
