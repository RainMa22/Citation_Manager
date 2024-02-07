package model.mla;

import org.junit.jupiter.api.BeforeEach;

public class MlaCitationTest {

    MlaCitation citationFull;
    MlaCitation citationMajorWork;
    MlaCitation citationOmitALot;

    @BeforeEach
    public void setup() {
        citationFull = new MlaCitation("Gregor Kiczales, John Lamping, Anurag Mendhekar",
                "Aspect-oriented programming", true, "ACM Computing Surveys",
                28, "4es", "1996-12-01",
                "Association for Computing Machinery", "2024-02-07",
                "10.1145/242224.242420");
    }
}
