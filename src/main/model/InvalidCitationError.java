package model;

// represent an Error thrown when program tries to add Citation of the wrong format to a different FullCitation
// not recoverable because Citations cannot be converted from one format to another
public class InvalidCitationError extends Error {
}
