import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthorListComponent } from './author/view/author-list/author-list.component';
import { AuthorViewComponent } from './author/view/author-view/author-view.component';
import { AuthorAddComponent } from './author/view/author-add/author-add.component';
import { AuthorEditComponent } from './author/view/author-edit/author-edit.component';

const routes: Routes = [
  {path: 'authors', component: AuthorListComponent},
  {path: 'authors/add', component: AuthorAddComponent},
  {path: 'authors/:uuid', component: AuthorViewComponent},
  {path: 'authors/:uuid/edit', component: AuthorEditComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
