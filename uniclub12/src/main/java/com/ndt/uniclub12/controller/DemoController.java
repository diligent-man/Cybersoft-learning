package com.ndt.uniclub12.controller;

import com.ndt.uniclub12.annotation.ValidFile;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


// HTTP verbs/actions: GET, POST, PATCH, PUT, DELETE, ...
// <HOST>:<PORT>/<URI_PATH>
// routing: tìm đường dẫn

@RestController
@RequestMapping("/api")
public class DemoController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }


    @GetMapping("/login")
    public String login() {
        return """
            <!DOCTYPE html>
            <html lang="en">
            <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Sign in — Bloomline</title>
            <link rel="preconnect" href="https://fonts.googleapis.com">
            <link href="https://fonts.googleapis.com/css2?family=Fraunces:ital,opsz,wght@0,9..144,300;0,9..144,500;0,9..144,600;1,9..144,500&family=Manrope:wght@400;500;600;700&display=swap" rel="stylesheet">
            <style>
              :root{
                --moss: #3f5c3f;
                --moss-dark: #2b4028;
                --cream: #faf6ee;
                --petal: #f2b6c6;
                --petal-deep: #e08aa4;
                --leaf-light: #cfe1c0;
                --sun: #e8b04b;
                --ink: #2c2c26;
                --line: rgba(63,92,63,0.18);
              }
            
              *{box-sizing:border-box;}
              html,body{margin:0;padding:0;}
            
              body{
                min-height:100vh;
                display:flex;
                align-items:center;
                justify-content:center;
                background:
                  radial-gradient(circle at 12% 18%, rgba(242,182,198,0.35), transparent 40%),
                  radial-gradient(circle at 88% 82%, rgba(207,225,192,0.45), transparent 45%),
                  var(--cream);
                font-family:'Manrope', sans-serif;
                color:var(--ink);
                position:relative;
                overflow:hidden;
                padding:24px;
              }
            
              /* Drifting petals */
              .petal{
                position:absolute;
                width:14px;
                height:14px;
                background:var(--petal);
                border-radius:0 60% 0 60%;
                opacity:0.7;
                animation:drift linear infinite;
              }
              .petal:nth-child(1){ left:6%; top:-5%; animation-duration:14s; animation-delay:0s; background:var(--petal);}
              .petal:nth-child(2){ left:22%; top:-8%; animation-duration:18s; animation-delay:2s; background:var(--leaf-light); width:10px; height:10px;}
              .petal:nth-child(3){ left:48%; top:-6%; animation-duration:16s; animation-delay:5s; background:var(--petal-deep);}
              .petal:nth-child(4){ left:68%; top:-9%; animation-duration:20s; animation-delay:1s; background:var(--petal); width:11px; height:11px;}
              .petal:nth-child(5){ left:84%; top:-4%; animation-duration:15s; animation-delay:7s; background:var(--leaf-light);}
              .petal:nth-child(6){ left:92%; top:-7%; animation-duration:19s; animation-delay:3s; background:var(--petal-deep); width:9px; height:9px;}
            
              @keyframes drift{
                0%{ transform:translateY(0) translateX(0) rotate(0deg); opacity:0.8;}
                100%{ transform:translateY(110vh) translateX(40px) rotate(260deg); opacity:0.2;}
              }
            
              @media (prefers-reduced-motion: reduce){
                .petal{ animation:none; display:none; }
              }
            
              .card{
                position:relative;
                z-index:2;
                width:100%;
                max-width:400px;
                background:#fffdf9;
                border:1px solid var(--line);
                border-radius:22px;
                padding:44px 38px 38px;
                box-shadow:0 24px 60px -20px rgba(43,64,40,0.25);
              }
            
              .sprout{
                width:38px;
                height:38px;
                margin-bottom:18px;
              }
            
              .eyebrow{
                font-size:12px;
                letter-spacing:0.14em;
                text-transform:uppercase;
                color:var(--moss);
                font-weight:600;
                margin:0 0 6px;
              }
            
              h1{
                font-family:'Fraunces', serif;
                font-weight:500;
                font-style:italic;
                font-size:32px;
                line-height:1.15;
                margin:0 0 8px;
                color:var(--moss-dark);
              }
            
              .sub{
                margin:0 0 30px;
                font-size:14.5px;
                color:#6b6b5f;
                line-height:1.5;
              }
            
              form{ display:flex; flex-direction:column; gap:18px; }
            
              .field{ display:flex; flex-direction:column; gap:6px; }
            
              label{
                font-size:12.5px;
                font-weight:600;
                color:var(--moss-dark);
                letter-spacing:0.01em;
              }
            
              input{
                font-family:'Manrope', sans-serif;
                font-size:15px;
                padding:12px 14px;
                border-radius:12px;
                border:1.5px solid var(--line);
                background:var(--cream);
                color:var(--ink);
                outline:none;
                transition:border-color 0.2s ease, background 0.2s ease;
              }
            
              input::placeholder{ color:#a8a89a; }
            
              input:focus{
                border-color:var(--moss);
                background:#fff;
                box-shadow:0 0 0 3px rgba(63,92,63,0.12);
              }
            
              .row-between{
                display:flex;
                align-items:center;
                justify-content:space-between;
                font-size:13px;
                margin-top:-4px;
              }
            
              .remember{
                display:flex;
                align-items:center;
                gap:7px;
                color:#5c5c50;
              }
            
              .remember input[type="checkbox"]{
                width:15px;
                height:15px;
                padding:0;
                accent-color:var(--moss);
                border-radius:4px;
              }
            
              a{
                color:var(--petal-deep);
                text-decoration:none;
                font-weight:600;
              }
              a:hover{ text-decoration:underline; }
            
              button{
                margin-top:6px;
                padding:13px 18px;
                border:none;
                border-radius:12px;
                background:var(--moss);
                color:#fdfcf7;
                font-family:'Manrope', sans-serif;
                font-size:15px;
                font-weight:700;
                letter-spacing:0.01em;
                cursor:pointer;
                transition:background 0.2s ease, transform 0.15s ease;
              }
            
              button:hover{ background:var(--moss-dark); }
              button:active{ transform:scale(0.98); }
            
              button:focus-visible,
              input:focus-visible,
              a:focus-visible{
                outline:2px solid var(--sun);
                outline-offset:2px;
              }
            
              .divider{
                display:flex;
                align-items:center;
                gap:12px;
                margin:26px 0 20px;
                color:#a8a89a;
                font-size:12px;
              }
              .divider::before,
              .divider::after{
                content:"";
                flex:1;
                height:1px;
                background:var(--line);
              }
            
              .form-error{
                min-height:16px;
                margin:2px 0 0;
                font-size:13px;
                color:#c0453f;
                text-align:center;
              }
            
              .footer-text{
                text-align:center;
                font-size:14px;
                color:#6b6b5f;
                margin:0;
              }
            
              @media (max-width:420px){
                .card{ padding:32px 24px 28px; border-radius:18px; }
                h1{ font-size:27px; }
              }
            </style>
            </head>
            <body>
            
              <div class="petal"></div>
              <div class="petal"></div>
              <div class="petal"></div>
              <div class="petal"></div>
              <div class="petal"></div>
              <div class="petal"></div>
            
              <div class="card">
                <svg class="sprout" viewBox="0 0 40 40" fill="none" xmlns="http://www.w3.org/2000/svg">
                  <path d="M20 36V18" stroke="#3f5c3f" stroke-width="2.2" stroke-linecap="round"/>
                  <path d="M20 18C20 18 8 18 8 8C8 8 20 6 20 18Z" fill="#cfe1c0" stroke="#3f5c3f" stroke-width="1.6" stroke-linejoin="round"/>
                  <path d="M20 22C20 22 32 22 32 12C32 12 20 10 20 22Z" fill="#f2b6c6" stroke="#e08aa4" stroke-width="1.6" stroke-linejoin="round"/>
                </svg>
            
                <p class="eyebrow">Bloomline</p>
                <h1>Welcome back to<br>the garden.</h1>
                <p class="sub">Sign in to pick up right where your season left off.</p>
            
                <form autocomplete="on">
                  <div class="field">
                    <label for="email">Email</label>
                    <input type="email" id="email" name="email" placeholder="you@bloomline.com" required>
                  </div>
            
                  <div class="field">
                    <label for="password">Password</label>
                    <input type="password" id="password" name="password" placeholder="Enter your password" required>
                  </div>
            
                  <div class="row-between">
                    <label class="remember">
                      <input type="checkbox" id="remember" name="remember">
                      Keep me signed in
                    </label>
                    <a href="#">Forgot password?</a>
                  </div>
            
                  <button type="submit" id="submitBtn">Sign in</button>
                  <p class="form-error" id="formError" role="alert"></p>
                </form>
            
                <div class="divider">or</div>
            
                <p class="footer-text">New here? <a href="#">Create an account</a></p>
              </div>
            
            <script>
              const API_URL = "http://localhost:8080/api/login"; // Spring Boot backend
            
              const form = document.querySelector("form");
              const submitBtn = document.getElementById("submitBtn");
              let errorEl = document.getElementById("formError");
            
              // Fallback: if the error element wasn't found in the markup, create one
              // so the script never crashes trying to set its textContent.
              if (!errorEl && form) {
                errorEl = document.createElement("p");
                errorEl.className = "form-error";
                errorEl.id = "formError";
                errorEl.setAttribute("role", "alert");
                form.appendChild(errorEl);
              }
            
              if (form) {
                form.addEventListener("submit", async (e) => {
                  e.preventDefault();
                  if (errorEl) errorEl.textContent = "";
            
                  const email = document.getElementById("email")?.value.trim() ?? "";
                  const password = document.getElementById("password")?.value ?? "";
                  const remember = document.getElementById("remember")?.checked ?? false;
            
                  if (submitBtn) {
                    submitBtn.disabled = true;
                    submitBtn.textContent = "Signing in…";
                  }
            
                  try {
                    const res = await fetch(API_URL, {
                      method: "POST",
                      headers: { "Content-Type": "application/json" },
                      body: JSON.stringify({ email, password, remember })
                    });
            
                    if (!res.ok) {
                      const data = await res.json().catch(() => ({}));
                      throw new Error(data.message || "Couldn't sign in. Check your details and try again.");
                    }
            
                    const data = await res.json();
                    if (data.token) {
                      localStorage.setItem("authToken", data.token);
                    }
                    window.location.href = "/api/hello";
            
                  } catch (err) {
                    if (errorEl) errorEl.textContent = err.message;
                  } finally {
                    if (submitBtn) {
                      submitBtn.disabled = false;
                      submitBtn.textContent = "Sign in";
                    }
                  }
                });
              }
            </script>
            </body>
            </html>
            """;
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(
        @Valid @RequestBody LoginRequest req
    ) {
        Map<String, String> payload = new HashMap<>();
        payload.put("email", req.getEmail());
        payload.put("password", req.getPassword());
        return ResponseEntity.ok(payload);
    }
}
