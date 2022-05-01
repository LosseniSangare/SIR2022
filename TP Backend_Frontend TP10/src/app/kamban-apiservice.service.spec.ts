import { TestBed } from '@angular/core/testing';

import { KambanAPIServiceService } from './kamban-apiservice.service';

describe('KambanAPIServiceService', () => {
  let service: KambanAPIServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(KambanAPIServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
