//UTC기준 (협정 세계시, 1970년 1월 1일 UTC 자정과의 시간 차이를 밀리초 단위로 표기)
//한국은 UTC+9
console.log(new Date());
console.log(new Date('Jun 5, 2022'));
console.log(new Date('2022-12-17T03:24:00'));

console.log(Date.now());
console.log(Date.parse('2022-12-17T03:24:00')); //밀리초 단위로 표현

const now = new Date();
now.setFullYear(2023);
now.setMonth(10); //0이 1월이다
console.log(now);
console.log(now.getFullYear());
console.log(now.getDate()); //0이 1일이다.
console.log(now.getDay()); //3 = 목요일
console.log(now.getTime());

console.log(now.toString());
console.log(now.toDateString());
console.log(now.toTimeString());
console.log(now.toISOString());
console.log(now.toLocaleString('en-US'));
console.log(now.toLocaleDateString('ko-KR')); 