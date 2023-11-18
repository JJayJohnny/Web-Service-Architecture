import { Component, OnInit } from '@angular/core';
import { BookDetails } from '../../model/book-details';
import { BookService } from '../../service/book.service';
import { ActivatedRoute } from '@angular/router';
import { AuthorDetails } from 'src/app/author/model/author-details';
import { AuthorService } from 'src/app/author/service/author.service';

@Component({
  selector: 'app-book-view',
  templateUrl: './book-view.component.html',
  styleUrls: ['./book-view.component.css']
})
export class BookViewComponent implements OnInit{

  book: BookDetails | undefined;
  author: AuthorDetails | undefined; 

  constructor(private service: BookService,
              private route: ActivatedRoute,
              private authorService: AuthorService){}

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.service.getBook(params['uuid']).subscribe(book => {
        this.book = book;
        this.authorService.getAuthor(book.author.id).subscribe(author => {
          this.author = author;
        })
      });
    })
  }

}
