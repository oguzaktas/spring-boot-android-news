import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NewsService } from '../service/news.service';
import { News } from '../model/news';
 
@Component({
  selector: 'app-news-form',
  templateUrl: './news-form.component.html',
  styleUrls: ['./news-form.component.css']
})
export class NewsFormComponent {
 
  news: News;
 
  constructor(private route: ActivatedRoute, private router: Router, private newsService: NewsService) {
    this.news = new News();
  }
 
  onSubmit() {
    this.newsService.save(this.news).subscribe(result => this.gotoNewsList());
  }
 
  gotoNewsList() {
    this.router.navigate(['/news']);
  }
}
