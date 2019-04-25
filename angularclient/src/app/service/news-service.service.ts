import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { News } from '../model/news';
import { Observable } from 'rxjs/Observable';
 
@Injectable()
export class NewsService {
 
  private newsURL: string;
 
  constructor(private http: HttpClient) {
    this.newsURL = 'http://localhost:8080/news';
  }
 
  public findAll(): Observable<News[]> {
    return this.http.get<News[]>(this.newsURL);
  }
 
  public save(news: News) {
    return this.http.post<News>(this.newsURL, news);
  }
}
