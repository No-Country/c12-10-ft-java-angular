import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'urlImage'
})
export class UrlImagePipe implements PipeTransform {

  api: string = 'https://nocountry-production-78d6.up.railway.app'

  transform( image:string):string {
    return `${this.api}/${image}` ;
  }

}
