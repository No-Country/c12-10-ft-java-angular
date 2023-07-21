import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'plural'
})
export class PluralPipe implements PipeTransform {

  transform(value: string, num:number): unknown {
    const newValue =`${value}s`
    // newValue.splice(newValue.length, 0,'s').join('');

    return num>1 ? newValue : value

  }

}
