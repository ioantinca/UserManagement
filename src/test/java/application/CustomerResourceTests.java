package application;

import application.services.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CustomerResourceTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountService accountService;

    @Test
    public void shouldWorkJustWithCustomerId() throws Exception {
        this.mockMvc.perform(post("/openAccount/23"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldNotWorkWithoutCustomerId() throws Exception {
        this.mockMvc.perform(post("/openAccount"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void shouldWorkWithCustomerIdAndInitialValueCustomerId() throws Exception {
        this.mockMvc.perform(post("/openAccount/23?initialValue=12"))
                .andDo(print())
                .andExpect(status().isOk());
    }

}
