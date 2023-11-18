import { Component, OnInit } from '@angular/core';
import { AuthorService } from '../../service/author.service';
import { ActivatedRoute } from '@angular/router';
import { AuthorDetails } from '../../model/author-details';
import { BookService } from 'src/app/book/service/book.service';
import { Books } from 'src/app/book/model/books';
import { Book } from 'src/app/book/model/book';

@Component({
  selector: 'app-author-view',
  templateUrl: './author-view.component.html',
  styleUrls: ['./author-view.component.css']
})
export class AuthorViewComponent implements OnInit{

  author: AuthorDetails | undefined;

  books: Books | undefined;

  constructor(private service: AuthorService, 
              private route: ActivatedRoute, 
              private bookService: BookService){}

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.service.getAuthor(params['uuid']).subscribe(author => this.author=author);
      this.bookService.getAuthorBooks(params['uuid']).subscribe(books => this.books = books);
    })
  }

  onDelete(book: Book): void{
    this.bookService.deleteBook(book.id).subscribe(() => this.ngOnInit())
  }
}
