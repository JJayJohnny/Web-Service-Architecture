import { Component, OnInit } from '@angular/core';
import { Books } from '../../model/books';
import { BookService } from '../../service/book.service';
import { Book } from '../../model/book';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit{
  books: Books | undefined;

  constructor(private service: BookService){}

  ngOnInit(): void {
    this.service.getBooks().subscribe(books => this.books = books)
  }

  onDelete(book: Book): void{
    this.service.deleteBook(book.id).subscribe(() => this.ngOnInit())
  }
}
