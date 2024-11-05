export function reportYoungestAgeAndTotalSalary(people) {
  return `youngestAge: ${youngestAge()}, totalSalary: ${totalSalary()}`;

  function youngestAge() {
    return Math.min(...people.map((p) => p.age));;
  }
  
  function totalSalary() {
    return people.reduce((total, p) => (total += p.salary), 0);
  }  
}
