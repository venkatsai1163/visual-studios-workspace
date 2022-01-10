import { Component, OnInit} from '@angular/core';
import { ServiceService } from '../service.service';

@Component({
  selector: 'app-dataview',
  templateUrl: './dataview.component.html',
  styleUrls: ['./dataview.component.scss']
})
export class DataviewComponent implements OnInit {

  constructor(private service:ServiceService) { }
   displayedColumns: string[] = ['Name','RollNumber','Mark1','Mark2','Mark3','Total','Grade'];
  dataSource:any;
  flag:any;
  flag_1:any;

  ngOnInit(): void {

   this.flag=true;
    this.flag_1=false;
    
    this.service.get_data().subscribe( data=>{
      console.log(data);
      if(data===null){
      this.flag=false;
      this.flag_1=true;
      }
      else
      this.dataSource =  data;
    }
    )
  }
}
