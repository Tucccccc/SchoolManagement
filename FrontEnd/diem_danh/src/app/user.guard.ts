import { CanActivateFn, Router } from '@angular/router';
import { UserService } from './user.service';
import { inject, Inject } from '@angular/core';
UserService
Inject

export const userGuard: CanActivateFn = (route, state) => {
  // return true;
  if(inject(UserService).isAuthenticated()) {
    return true;
  } else {
    inject(Router).navigate(['/login']);
    return false;
  }
};

export const adminGuard: CanActivateFn = (route, state) => {
  if(inject(UserService).isAdmin()) {
    return true;
  } else {
    inject(Router).navigate(['/login']);
    return false;
  }
}