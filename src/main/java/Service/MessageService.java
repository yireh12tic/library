package Service;

import Repository.MessageRepository;
import model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll(){

        return (List<Message>) messageRepository.getAll();
    }
    public Optional<Message> getMessage(int id){
        return messageRepository.getMessage(id);
    }

    public Message save(Message message){
        if(message.getIdMessage()==null){
            return messageRepository.save(message);
        } else{
            Optional<Message> messageEncontrado =  messageRepository.getMessage(message.getIdMessage());
            if(messageEncontrado.isEmpty()){
                return messageRepository.save(message);
            }else{
                return message;
            }
        }
    }
    public Message update(Message message){
        if(message.getIdMessage() != null){
            Optional<Message> messageEncontrado = getMessage(message.getIdMessage());
            if(!messageEncontrado.isEmpty()){
                messageEncontrado.get().setMessageText(message.getMessageText());
            }
            return messageRepository.save(messageEncontrado.get());
        }
        return message;
    }
    public boolean delete(int id){
        Boolean respuesta = getMessage(id).map(elemento -> {
            messageRepository.delete(elemento);
            return true;
        }).orElse(false);
        return respuesta;
    }

}
