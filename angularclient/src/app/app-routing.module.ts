import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { NewsListComponent } from './news-list/news-list.component';
import { NewsFormComponent } from './news-form/news-form.component';
 
const routes: Routes = [
  { path: 'news', component: NewsListComponent },
  { path: 'addnews', component: NewsFormComponent }
];
 
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
