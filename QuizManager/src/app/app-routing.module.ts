import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
//import { LoginComponent } from './login/login.component';
import { GradesComponent } from './grades/grades.component';
import { PastQuizzesComponent } from './past-quizzes/past-quizzes.component';
import { CurrentQuizzesComponent } from './current-quizzes/current-quizzes.component';

const routes: Routes = [
  { path: '', redirectTo: '/', pathMatch: 'full'},
  { path: 'Grades', component:  GradesComponent},
  { path: 'PastQuizzes', component:  PastQuizzesComponent},
  { path: 'CurrentQuizzes', component:  CurrentQuizzesComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const componentRoutes = [GradesComponent, PastQuizzesComponent, CurrentQuizzesComponent]