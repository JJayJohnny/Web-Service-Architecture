import { Component, OnInit } from '@angular/core';
import { BookForm } from '../../model/book-form';
import { BookService } from '../../service/book.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-book-edit',
  templateUrl: './book-edit.component.html',
  styleUrls: ['./book-edit.component.css']
})
export class BookEditComponent implements OnInit{

  book: BookForm | undefined;
  uuid: String | undefined;

  constructor(private service: BookService,
              private route: ActivatedRoute,
              private router: Router){}

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.service.getBook(params['uuid']).subscribe(book => {
        this.book = {
          title: book.title,
          pages: book.pages,
          author: book.author.id
        }
        this.uuid = book.id;
      })
    })
  }

  onSubmit(): void{
    this.service.putBook(this.uuid!, this.book!).subscribe(() => this.router.navigate(['/authors', this.book!.author]))
  }

}
