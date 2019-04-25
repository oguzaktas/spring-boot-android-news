import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { NewsListComponent } from './news-list/news-list.component.ts';
import { NewsFormComponent } from './news-form/news-form.component.ts';
import { NewsService } from './service/news-service.service.ts';
 
@NgModule({
  declarations: [
    AppComponent,
    NewsListComponent,
    NewsFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [NewsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
