package cz.engeto.crypto.controller;

import cz.engeto.crypto.model.CryptoDTO;
import cz.engeto.crypto.service.CryptoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class CryptoController {

    private final CryptoService cryptoService;

    public CryptoController(CryptoService cryptoService) {
        this.cryptoService = cryptoService;
    }

    @PostMapping("/cryptos")
    public ResponseEntity addCrypto(@RequestBody CryptoDTO cryptoDTO) {
        cryptoService.addCrypto(cryptoDTO);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/cryptos")
    public ResponseEntity getAllCryptos() {
        List<CryptoDTO> cryptos = cryptoService.getAllCryptos();
        return new ResponseEntity(cryptos, HttpStatus.OK);
    }

}
