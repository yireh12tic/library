package Service;

import Repository.LibraryRepository;
import model.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {
    @Autowired
    private LibraryRepository libraryRepository;

    public List<Library> getAll(){

        return (List<Library>) libraryRepository.getAll();
    }
    public Optional<Library> getLibrary(int id){
        return libraryRepository.getLibrary(id);
    }

    public Library save(Library library){
        if(library.getId() == null){
            return libraryRepository.save(library);
        } else{
            Optional<Library> libraryEncontrada =  libraryRepository.getLibrary(library.getId());
            if(libraryEncontrada.isEmpty()){
                return libraryRepository.save(library);
            }else{
                return library;
            }
        }
    }
    public Library update(Library library){
        if(library.getId() != null){
            Optional<Library> libraryEncontrada = getLibrary(library.getId());
            if(!libraryEncontrada.isEmpty()){
                if(library.getName() != null){
                    libraryEncontrada.get().setName(library.getName());
                }
                if(library.getCapacity() != null){
                    libraryEncontrada.get().setCapacity(library.getCapacity());
                }
                if(library.getDescription() != null){
                    libraryEncontrada.get().setDescription(library.getDescription());
                }
                if(library.getCategory() != null){
                    libraryEncontrada.get().setCategory(library.getCategory());
                }
                return libraryRepository.save(libraryEncontrada.get());
            }
        }
        return library;
    }
    public boolean delete(int id){
        Boolean respuesta= getLibrary(id).map(elemento -> {
            libraryRepository.delete(elemento);
            return true;
        }).orElse(false);
        return respuesta;
    }

}
