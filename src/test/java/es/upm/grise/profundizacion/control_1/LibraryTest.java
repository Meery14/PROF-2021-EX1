package es.upm.grise.profundizacion.control_1;


import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions.*;

import static junit.framework.TestCase.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LibraryTest {
	
	@Test
	public void givenAValidAndNotDuplicatedBookInLibrary_whenAddBook_thenAValidBoodIsAddedToLibrary() throws DuplicatedBookException, NonExistingBookException, EmptyLibraryException {
		Book libroValido = new Book("Don Quijote");
		Library libreria = new Library();
		libreria.addBook(libroValido);
		assertEquals(libroValido.getTitle(), libreria.getBook("Don Quijote").getTitle());
	}

	@Test
	public void givenADuplicatedBookInLibrary_whenAddBook_thenThrowsException() throws DuplicatedBookException {
		Book libroValido = new Book("Don Quijote");
		Book libroNoValido = new Book("Don Quijote");
		Library libreria = new Library();
		libreria.addBook(libroValido);
		assertThrows(DuplicatedBookException.class, () -> libreria.addBook(libroNoValido));
	}

	@Test
	public void givenANotExistingBookInLibrary_whenGetBook_thenThrowsException() throws DuplicatedBookException {
		Book libroValido = new Book("Don Quijote");
		Library libreria = new Library();
		libreria.addBook(libroValido);
		assertThrows(NonExistingBookException.class, () -> libreria.getBook("Hamlet"));
	}

	@Test
	public void givenEmptyLibrary_whenGetBook_thenThrowsException(){
		Library libreria = new Library();
		assertThrows(EmptyLibraryException.class, () -> libreria.getBook("Hamlet"));
	}

	@Test
	public void givenAValidAndNotDuplicatedBookInLibrary_whenGetBook_thenReturnBook() throws DuplicatedBookException, NonExistingBookException, EmptyLibraryException {
		Book libroValido = new Book("Don Quijote");
		Library libreria = new Library();
		libreria.addBook(libroValido);
		assertEquals(libroValido.getTitle(), libreria.getBook("Don Quijote").getTitle());
	}

	@Test
	public void givenAnExistingBookInLibrary_whenRemoveBook_thenRemoveBook() throws DuplicatedBookException {
		Book libroValido = new Book("Don Quijote");
		Book libroValido2 = new Book("Hamlet");
		Library libreria = new Library();
		Library libreriaVacia = new Library();
		libreria.addBook(libroValido);
		libreria.addBook(libroValido2);
		libreria.removeBook(libroValido);
		assertThrows(NonExistingBookException.class, () -> libreria.getBook("Don Quijote"));
	}





}
