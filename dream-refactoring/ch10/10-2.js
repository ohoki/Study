function disabilityAmount(employee) {
  if(isNotEligibleForDisability()) {
    return 0;
  } else {
    return 1;
  }
}

function isNotEligibleForDisability(employee) {
  return (
    employee.seniority < 2 ||
    employee.monthsDisabled > 12 ||
    employee.isPartTime
  );
}
