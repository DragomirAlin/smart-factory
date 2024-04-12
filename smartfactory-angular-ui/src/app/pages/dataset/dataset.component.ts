import {AfterViewInit, Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {AcquisitionService, Data} from "../../services/api";
import {DatasetDatasource} from "../../services/datasource/dataset.datasource";
import {MatPaginator, PageEvent} from "@angular/material/paginator";
import {MatSort} from "@angular/material/sort";
import {ActivatedRoute, Router} from "@angular/router";
import {catchError, finalize} from "rxjs/operators";
import {of} from "rxjs";
import {Pagination} from "../../services/api/model/pagination";
import {HttpParams} from "@angular/common/http";

@Component({
  selector: 'app-dataset',
  templateUrl: './dataset.component.html',
  styleUrls: ['./dataset.component.scss']
})
export class DatasetComponent implements OnInit, AfterViewInit {
  dataset: Data[] = [];
  currentPage = 0;
  totalItems = 0;
  totalPages = 0;
  pageSize = 0;
  displayedColumns = ["topic", "payload", "metadata"];



  constructor(private router: Router, private activatedRoute: ActivatedRoute, private acquisitionService: AcquisitionService) {
    this.activatedRoute.queryParams.subscribe(p => {
      this.loadingDataset(p['page'], p['page_size']);
      p['page'] = 5;
      p['page_size'] = 5;
    });
  }

  ngOnInit(): void {

  }

  ngAfterViewInit(): void {
  }

  loadingDatasetPage() {
    // @ts-ignore
    this.dataSource.loadDataset();
  }

  pagination(event?: PageEvent): void {
    this.loadingDataset(event?.pageIndex, event?.pageSize);

  }

  loadingDataset(currentPage: number = 0, pageSize: number = 5) {
    this.router.navigate([],
      {
        relativeTo: this.activatedRoute,
        queryParams: {page: currentPage, page_size: pageSize},
        queryParamsHandling: 'merge'
    })

    this.acquisitionService.getData(currentPage, pageSize)
      .subscribe((response: any) => {
        this.dataset = response.data;
        this.currentPage = response.currentPage;
        this.totalItems = response.totalItems;
        this.totalPages = response.totalPages;
        this.pageSize = response.pageSize;
      });
  }

}
