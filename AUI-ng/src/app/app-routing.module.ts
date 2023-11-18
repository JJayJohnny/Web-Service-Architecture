import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthorListComponent } from './author/view/author-list/author-list.component';
import { AuthorViewComponent } from './author/view/author-view/author-view.component';
import { AuthorAddComponent } from './author/view/author-add/author-add.component';
import { AuthorEditComponent } from './author/view/author-edit/author-edit.component';
import { BookViewComponent } from './book/view/book-view/book-view.component';
import { BookEditComponent } from './book/view/book-edit/book-edit.component';
import { BookAddComponent } from './book/view/book-add/book-add.component';
import { BookListComponent } from './book/view/book-list/book-list.component';

const routes: Routes = [
  {path: 'authors', component: AuthorListComponent},
  {path: 'authors/add', component: AuthorAddComponent},
  {path: 'authors/:uuid', component: AuthorViewComponent},
  {path: 'authors/:uuid/edit', component: AuthorEditComponent},
  {path: 'authors/:uuid/addBook', component: BookAddComponent},
  {path: 'books', component: BookListComponent},
  {path: 'books/:uuid', component: BookViewComponent},
  {path: 'books/:uuid/edit', component: BookEditComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
