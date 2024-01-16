
from pathlib import Path
import tkinter
from menu2 import *
import mysql.connector
# Conectar ao banco de dados MySQL
conexao = mysql.connector.connect(
    host='localhost',
    user='root',
    password='55879276',
    database='projetoteste'
)
if conexao.is_connected:  
    # Criar um cursor
    cursor = conexao.cursor()

# from tkinter import *
# Explicit imports to satisfy Flake8
from tkinter import Tk, Canvas, Entry, Text, Button, PhotoImage


OUTPUT_PATH = Path(__file__).parent
ASSETS_PATH = OUTPUT_PATH / Path(r"D:\Documents\Desktop\projetoTesteEngenharia\ProjetoPadariaPython\tela-login")


def relative_to_assets(path: str) -> Path:
    return ASSETS_PATH / Path(path)


window = Tk()

window.geometry("1440x920")
window.configure(bg = "#FFFFFF")


canvas = Canvas(
    window,
    bg = "#FFFFFF",
    height = 920,
    width = 1440,
    bd = 0,
    highlightthickness = 0,
    relief = "ridge"
)

canvas.place(x = 0, y = 0)
image_image_1 = PhotoImage(
    file=relative_to_assets("image_1.png"))
image_1 = canvas.create_image(
    720.0,
    460.0,
    image=image_image_1
)

image_image_2 = PhotoImage(
    file=relative_to_assets("image_2.png"))
image_2 = canvas.create_image(
    720.0,
    35.0,
    image=image_image_2
)

image_image_3 = PhotoImage(
    file=relative_to_assets("image_3.png"))
image_3 = canvas.create_image(
    720.0,
    512.0,
    image=image_image_3
)

canvas.create_text(
    667.0,
    216.0,
    anchor="nw",
    text="LOGIN",
    fill="#7F4600",
    font=("MontserratRoman Bold", 32 * -1)
)

button_image_1 = PhotoImage(
    file=relative_to_assets("button_1.png"))

email = tkinter.StringVar()
senha = tkinter.StringVar()

button_1 = Button(
    image=button_image_1,
    borderwidth=0,
    highlightthickness=0,
    command=lambda: loginCliente(email, senha),
    relief="flat"
)
button_1.place(
    x=591.0,
    y=675.0,
    width=258.0,
    height=53.0
)

button_image_2 = PhotoImage(
    file=relative_to_assets("button_2.png"))
button_2 = Button(
    image=button_image_2,
    borderwidth=0,
    highlightthickness=0,
    command=lambda: print("button_2 clicked"),
    relief="flat"
)
button_2.place(
    x=633.0,
    y=628.0,
    width=174.0,
    height=22.0
)

button_image_3 = PhotoImage(
    file=relative_to_assets("button_3.png"))
button_3 = Button(
    image=button_image_3,
    borderwidth=0,
    highlightthickness=0,
    command=lambda: print("button_3 clicked"),
    relief="flat"
)
button_3.place(
    x=598.0,
    y=788.0,
    width=246.0,
    height=22.0
)

image_image_4 = PhotoImage(
    file=relative_to_assets("image_4.png"))
image_4 = canvas.create_image(
    721.0,
    499.0,
    image=image_image_4
)

entry_image_1 = PhotoImage(
    file=relative_to_assets("entry_1.png"))
entry_bg_1 = canvas.create_image(
    721.0,
    499.5,
    image=entry_image_1
)
entry_1 = Entry(
    bd=0,
    bg="#FFFFFF",
    fg="#000716",
    highlightthickness=0,
    textvariable= email
)
entry_1.place(
    x=544.0,
    y=477.0,
    width=354.0,
    height=43.0
)

entry_image_2 = PhotoImage(
    file=relative_to_assets("entry_2.png"))
entry_bg_2 = canvas.create_image(
    721.0,
    591.5,
    image=entry_image_2
)
entry_2 = Entry(
    bd=0,
    bg="#FFFFFF",
    fg="#000716",
    highlightthickness=0,
    textvariable= senha
)
entry_2.place(
    x=544.0,
    y=569.0,
    width=354.0,
    height=43.0
)

canvas.create_text(
    683.0,
    444.0,
    anchor="nw",
    text="E-Mail",
    fill="#7F4600",
    font=("MontserratRoman Regular", 24 * -1)
)

image_image_5 = PhotoImage(
    file=relative_to_assets("image_5.png"))
image_5 = canvas.create_image(
    720.0,
    591.0,
    image=image_image_5
)

canvas.create_text(
    683.0,
    536.0,
    anchor="nw",
    text="Senha",
    fill="#7F4600",
    font=("MontserratRoman Regular", 24 * -1)
)

image_image_6 = PhotoImage(
    file=relative_to_assets("image_6.png"))
image_6 = canvas.create_image(
    720.0,
    346.0,
    image=image_image_6
)
window.resizable(False, False)
window.mainloop()
