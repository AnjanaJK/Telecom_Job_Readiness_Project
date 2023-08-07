import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cust } from '../class/cust';
import { Manager } from '../class/manager';
import { Engineer } from '../class/engineer';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  private mainUrl = "http://localhost:8090";

  constructor(private http: HttpClient) { }

  displayAllCust(): Observable<any> {
    return this.http.get<any>(`${this.mainUrl}/getAllCust`);
  }

  displayAllEng(): Observable<any> {
    return this.http.get<any>(`${this.mainUrl}/getAllEng`);
  }

  displayAllMngr(): Observable<any> {
    return this.http.get<any>(`${this.mainUrl}/getAllMngr`);
  }

  // -----------------------------------------------------


  addNewCust(formdata: any): Observable<any> {
    // console.warn(formdata);
    return this.http.post(`${this.mainUrl}/addNewCust`, formdata);
  }

  getCustomerById(customerId: number, userId: number): Observable<Cust> {
    const url = `${this.mainUrl}/editCustFetchDetails/${customerId}/${userId}`;
    return this.http.get<Cust>(url);
  }

  updateCustomerRecord(formdata: any, customerId: number, userId: number): Observable<any> {
    return this.http.put(`${this.mainUrl}/updateCustRecord/${customerId}/${userId}`, formdata);
  }

  deleteCustRecord(customerId: number, userId: number): Observable<any> {
    return this.http.delete(`${this.mainUrl}/deleteCustRecord/${customerId}/${userId}`);
  }

  // ------------------

  addNewManager(formdata: any): Observable<any> {
    console.warn(formdata);
    return this.http.post(`${this.mainUrl}/addNewManager`, formdata);
  }

  getManagerById(managerId: number, userId: number): Observable<Manager> {
    const url = `${this.mainUrl}/editManagerFetchDetails/${managerId}/${userId}`;
    return this.http.get<Manager>(url);
  }

  updateManagerRecord(formdata: any, managerId: number, userId: number): Observable<any> {
    return this.http.put(`${this.mainUrl}/updateManagerRecord/${managerId}/${userId}`, formdata);
  }

  deleteManagerRecord(managerId: number, userId: number): Observable<any> {
    return this.http.delete(`${this.mainUrl}/deleteManagerRecord/${managerId}/${userId}`);
  }

  // ------------------

  getManagers(): Observable<Manager[]> {
    return this.http.get<Manager[]>(`${this.mainUrl}/getManagers`);
  }

  addNewEngineer(formdata: any): Observable<any> {
    console.warn(formdata);
    return this.http.post(`${this.mainUrl}/addNewEngineer`, formdata);
  }

  getEngineerById(engineerId: number, userId: number): Observable<Engineer> {
    const url = `${this.mainUrl}/editEngineerFetchDetails/${engineerId}/${userId}`;
    return this.http.get<Engineer>(url);
  }

  updateEngineerRecord(formdata: any, engineerId: number, userId: number): Observable<any> {
    return this.http.put(`${this.mainUrl}/updateEngineerRecord/${engineerId}/${userId}`, formdata);
  }

  deleteEngineerRecord(engineerId: number, userId: number): Observable<any> {
    return this.http.delete(`${this.mainUrl}/deleteEngineerRecord/${engineerId}/${userId}`);
  }

}
