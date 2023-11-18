import { Component, OnInit } from '@angular/core';
import { BookService } from '../../service/book.service';
import { ActivatedRoute, Router } from '@angular/router';
import { BookForm } from '../../model/book-form';

@Component({
  selector: 'app-book-add',
  templateUrl: './book-add.component.html',
  styleUrls: ['./book-add.component.css']
})
export class BookAddComponent implements OnInit{

  title: String | undefined;
  pages: number | undefined;
  authorId: String | undefined;

  constructor(private service: BookService,
              private router: Router,
              private route: ActivatedRoute){}

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.authorId = params['uuid']
    })
  }

  onSubmit(): void{
    let uuid = crypto.randomUUID()
    let book: BookForm;
    book = {
      title: this.title!,
      pages: this.pages!,
      author: this.authorId!
    };
    this.service.putBook(uuid, book).subscribe(() => this.router.navigate(['/authors', this.authorId]))
  }
}
