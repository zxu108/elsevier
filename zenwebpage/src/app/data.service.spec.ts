import { TestBed } from '@angular/core/testing';

import { DatService } from './dat.service';

describe('DatService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: DatService = TestBed.get(DatService);
    expect(service).toBeTruthy();
  });
});
