export function adjustedCapital(instrument) {
  if (!isEligibleForAdjustedCapital()) {
    return 0;
  }

  return (
    (instrument.income / instrument.duration) * anInstrument.adjustmentFactor;
  );
}

function isEligibleForAdjustedCapital() {
  return instrument.capital > 0 && instrument.interestRate > 0 && instrument.duration > 0;
}
