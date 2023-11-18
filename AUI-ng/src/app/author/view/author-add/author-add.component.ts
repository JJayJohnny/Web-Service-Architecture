import { Component } from '@angular/core';
import { AuthorForm } from '../../model/author-form';
import { AuthorService } from '../../service/author.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-author-add',
  templateUrl: './author-add.component.html',
  styleUrls: ['./author-add.component.css']
})
export class AuthorAddComponent {

  name: string | undefined;
  age: number | undefined;

  constructor(private service: AuthorService,
              private router: Router){}

  onSubmit(): void{
    let author: AuthorForm;
    author = {
      name: this.name!,
      age: this.age!
    };
    let uuid = crypto.randomUUID();
    this.service.putAuthor(uuid, author).subscribe(() => this.router.navigate(['/authors']));
  }
}
