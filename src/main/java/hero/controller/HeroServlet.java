package com.hero.controller;

import com.hero.dao.HeroDao;
import com.hero.dao.HeroDao;
import com.hero.model.Hero;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/")
public class HeroServlet extends HttpServlet {
    private HeroDao heroDAO;

    @Override
    public void init() {
        heroDAO = new HeroDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String aksi = request.getParameter("aksi");
        if (aksi == null) aksi = "list";

        switch (aksi) {
            case "new":
                tampilForm(request, response);
                break;
            case "insert":
                insertHero(request, response);
                break;
            case "edit":
                tampilEditForm(request, response);
                break;
            case "update":
                updateHero(request, response);
                break;
            case "delete":
                deleteHero(request, response);
                break;
            default:
                listHero(request, response);
        }
    }

    private void listHero(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Hero> list = heroDAO.getAll();
        request.setAttribute("listHero", list);
        request.getRequestDispatcher("hero-list.jsp").forward(request, response);
    }

    private void tampilForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("hero-form.jsp").forward(request, response);
    }

    private void insertHero(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String nama = request.getParameter("nama");
        String kategori = request.getParameter("kategori");
        String gender = request.getParameter("gender");

        Hero hero = new Hero();
        hero.setNama(nama);
        hero.setKategori(kategori);
        hero.setGender(gender);

        heroDAO.insert(hero);
        response.sendRedirect("?");
    }

    private void tampilEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Hero hero = heroDAO.getById(id);
        request.setAttribute("hero", hero);
        request.getRequestDispatcher("hero-form.jsp").forward(request, response);
    }

    private void updateHero(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nama = request.getParameter("nama");
        String kategori = request.getParameter("kategori");
        String gender = request.getParameter("gender");

        Hero hero = new Hero(id, nama, kategori, gender);
        heroDAO.update(hero);
        response.sendRedirect("?");
    }

    private void deleteHero(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        heroDAO.delete(id);
        response.sendRedirect("?");
    }
}