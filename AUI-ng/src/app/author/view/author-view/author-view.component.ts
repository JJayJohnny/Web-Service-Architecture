import { Component, OnInit } from '@angular/core';
import { AuthorService } from '../../service/author.service';
import { ActivatedRoute } from '@angular/router';
import { AuthorDetails } from '../../model/author-details';

@Component({
  selector: 'app-author-view',
  templateUrl: './author-view.component.html',
  styleUrls: ['./author-view.component.css']
})
export class AuthorViewComponent implements OnInit{

  author: AuthorDetails | undefined;

  constructor(private service: AuthorService, private route: ActivatedRoute){}

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.service.getAuthor(params['uuid']).subscribe(author => this.author=author);
    })
  }
}
