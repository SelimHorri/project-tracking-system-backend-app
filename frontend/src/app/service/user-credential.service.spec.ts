import { TestBed } from '@angular/core/testing';

import { UserCredentialService } from './user-credential.service';

describe('UserCredentialService', () => {
  let service: UserCredentialService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UserCredentialService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
