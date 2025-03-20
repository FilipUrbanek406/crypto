package cz.engeto.crypto.controller;

import cz.engeto.crypto.model.CryptoDTO;
import cz.engeto.crypto.service.CryptoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity getAllCryptos(@RequestParam(required = false) String sort) {
        List<CryptoDTO> cryptos;
        if ("price".equalsIgnoreCase(sort)) {
            cryptos = cryptoService.sortCryptosByPrice();
        } else if ("name".equalsIgnoreCase(sort)) {
            cryptos = cryptoService.sortCryptosByName();
        } else if ("quantity".equalsIgnoreCase(sort)) {
            cryptos = cryptoService.sortCryptosByQuantity();
        } else {
            cryptos = cryptoService.getAllCryptos();
        }
        return new ResponseEntity(cryptos, HttpStatus.OK);
    }

    @GetMapping("/cryptos/{id}")
    public ResponseEntity getCryptoById(@PathVariable Integer id) {
        CryptoDTO crypto = cryptoService.getCryptoById(id);
        if (crypto == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(crypto, HttpStatus.OK);
    }

    @PutMapping("/cryptos/updateCryptos/{id}")
    public ResponseEntity updateCrypto(@PathVariable Integer id, @RequestBody CryptoDTO cryptoDTO) {
        CryptoDTO crypto = cryptoService.getCryptoById(id);
        if (crypto == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        crypto.setName(cryptoDTO.getName());
        crypto.setPrice(cryptoDTO.getPrice());
        crypto.setQuantity(cryptoDTO.getQuantity());
        crypto.setSymbol(cryptoDTO.getSymbol());
        return new ResponseEntity(crypto, HttpStatus.OK);
    }

    @GetMapping("/cryptos/portfolioValue")
    public ResponseEntity getPortfolioValue(){
        double cryptos = cryptoService.getPortfolioValue();
        return new ResponseEntity(cryptos, HttpStatus.OK);
    }
}
