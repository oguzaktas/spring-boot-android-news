import { Component, OnInit } from '@angular/core';
import { News } from '../model/news';
import { NewsService } from '../service/news.service';
 
@Component({
  selector: 'app-news-list',
  templateUrl: './news-list.component.html',
  styleUrls: ['./news-list.component.css']
})
export class NewsListComponent implements OnInit {
 
  news: News[];
 
  constructor(private newsService: NewsService) {
  }
 
  ngOnInit() {
    this.newsService.findAll().subscribe(data => {
      this.news = data;
    });
  }
}
