import { Component, OnInit } from '@angular/core';
import { AuthorService } from '../../service/author.service';
import { Authors } from '../../model/authors';
import { Author } from '../../model/author';

@Component({
  selector: 'app-author-list',
  templateUrl: './author-list.component.html',
  styleUrls: ['./author-list.component.css']
})
export class AuthorListComponent implements OnInit{

  constructor(private service: AuthorService){}

  authors: Authors | undefined;

  ngOnInit(): void {
    this.service.getAuthors().subscribe(authors => this.authors=authors)
  }

  onDelete(author: Author): void{
    this.service.deleleAuthor(author.id).subscribe(() => this.ngOnInit());
  }
}
