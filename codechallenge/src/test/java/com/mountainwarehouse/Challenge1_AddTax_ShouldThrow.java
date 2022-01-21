import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.nio.BufferOverflowException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class Challenge1_AddTax_ShouldThrow {
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 10, 0.5, 15 },
                { (Double.MAX_VALUE - 1) / 2, 1, Double.MAX_VALUE - 1 },
                { 1, 0, 1 },
                { 0, 1, 0 }
        });
    }

    private double fNonTaxAmount;
    private double fTaxRate;
    private double fExpectedResult;

    public Challenge1_AddTax_ShouldThrow(double nonTaxAmount, double taxRate, double expectedResult) {
        fNonTaxAmount = nonTaxAmount;
        fTaxRate = taxRate;
        fExpectedResult = expectedResult;
    }

    @Test
    public void test() {
        assertThrows(BufferOverflowException, Challenge_1.AddTax(fNonTaxAmount, fTaxRate));
    }
}
