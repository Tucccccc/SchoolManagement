import { Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { ProfileComponent } from './profile/profile.component';
import { UpdateUserComponent } from './update-user/update-user.component';
import { UserListComponent } from './user-list/user-list.component';
import { adminGuard, userGuard } from './user.guard';
userGuard
adminGuard

// Only ADMIN can access to register, but all can access to profile, so profile just need authenticate, does not need any role
export const routes: Routes = [
    {path: 'login', component: LoginComponent},
    {path: 'register', component: RegisterComponent, canActivate: [adminGuard]},
    {path: 'profile', component: ProfileComponent, canActivate: [userGuard]},
    {path: 'update/:id', component: UpdateUserComponent, canActivate: [adminGuard]},
    {path: 'users', component: UserListComponent, canActivate: [adminGuard]},
    {path: '**', component: LoginComponent},
    {path: '', redirectTo: '/login', pathMatch: 'full'},
];