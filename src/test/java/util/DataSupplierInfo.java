package util;


import io.github.sskorol.core.DataSupplier;

import objects.ui.Milestone;
import objects.ui.TestCase;

import java.util.stream.Stream;

public class DataSupplierInfo {

    @DataSupplier(name = "Test case positive")
    public Stream<TestCase> createPositiveTestCase() {
        return Stream.of(
                new TestCase("This is title", "Test Case", "Test Case (Text)", "Regression",
                        "High", "2", "No", " None", "These are preconditions", "These are steps",
                        "This is expected result"),
                new TestCase("Title", "", "", "Security",
                        "", "", "", "", "", "", ""));
    }

    @DataSupplier(name = "Test case negative")
    public Stream<TestCase> createNegativeTestCase() {
        return Stream.of(
                new TestCase("", "", "", "",
                        "", "", "", "", "", "",
                        "This is expected result"),
                new TestCase("", "", "", "",
                        "", "2", "No", " None", "Preconditions",
                        "Steps", "Expected Result"));
    }

    @DataSupplier(name = "Test case edit positive")
    public Stream<TestCase> editTestCaseData() {
        return Stream.of(
                new TestCase("New title", "", "", "",
                        "", "", "", "", "", "",
                        ""),
                new TestCase("", "", "", "",
                        "", "", "", "", "",
                        "", ""));
    }

    @DataSupplier(name = "Create milestone positive")
    public Stream<Milestone> createMilestone() {
        return Stream.of(
                new Milestone("Name", "Reference", "Description"),
                new Milestone("Milestone name", "", ""));
    }

    @DataSupplier(name = "Create one milestone example positive")
    public Milestone createOneMilestone() {
        return
                new Milestone("Name", "Reference", "Description");
    }

    @DataSupplier(name = "Create milestone negative")
    public Stream<Milestone> createMilestoneWithRequiredFieldsEmpty() {
        return Stream.of(
                new Milestone("", "", ""),
                new Milestone("", "Ref", "Description"));
    }
}
