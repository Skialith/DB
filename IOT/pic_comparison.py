# Image comparison GUI
# Load images from two specified catalogues and display them side-by-side in the GUI for comparison.
# The user can browse the next set of images in the catalogue by clicking a button.

# Main functions:
# 1. loads image files from two specified directories.
# 2. displays the images from the two directories side by side in the GUI.
# 3. Provides a button that the user can click to view the next set of images in each directory.

# Input:
# - Paths to the two directories containing the images.

# Output:
# - A GUI for comparing images from two directories side-by-side.

# - Example usage:
# - After running the program, it will automatically load the first set of images
# - from both directories and display them on the interface.
# - The user can click on the "Next" button to browse the next set of images in each catalogue.
# - If the last set of images in the catalogue is reached, the "Next" button will not load any new images.

# Note:
# - Make sure that the dependency libraries 'PIL' and 'tkinter' are installed.
# - Image files should be in a compatible format such as JPG or PNG.
# - The program assumes that both directories have the same number of images
# - and that the images are named in a way that allows them to be sorted correctly.
# - If the number of images in the directories is different,
# - or if the end of either directory is reached, the "Next" button will no longer work.


import os
from PIL import Image, ImageTk
import tkinter as tk

class ImageComparator:
    def __init__(self, dir1, dir2):
        self.files1 = sorted(os.listdir(dir1))
        self.files2 = sorted(os.listdir(dir2))
        self.index = 0

        self.root = tk.Tk()
        self.root.title("Image Comparison")
        self.root.geometry("1300x1000")  # Adjust the window size as needed

        self.frame1 = tk.Frame(self.root)
        self.frame1.grid(row=0, column=0, padx=10, pady=10)

        self.frame2 = tk.Frame(self.root)
        self.frame2.grid(row=1, column=0, padx=10, pady=10)

        self.image1_path1 = os.path.join(dir1, self.files1[self.index])
        self.image1_path2 = os.path.join(dir1, self.files1[self.index + 1])
        self.image2_path1 = os.path.join(dir2, self.files2[self.index])
        self.image2_path2 = os.path.join(dir2, self.files2[self.index + 1])

        self.image1_1 = Image.open(self.image1_path1)
        self.image1_2 = Image.open(self.image1_path2)
        self.image2_1 = Image.open(self.image2_path1)
        self.image2_2 = Image.open(self.image2_path2)

        self.image1_1 = self.image1_1.resize((600, 340))
        self.image1_2 = self.image1_2.resize((600, 340))
        self.image2_1 = self.image2_1.resize((600, 340))
        self.image2_2 = self.image2_2.resize((600, 340))

        self.photo1_1 = ImageTk.PhotoImage(self.image1_1)
        self.photo1_2 = ImageTk.PhotoImage(self.image1_2)
        self.photo2_1 = ImageTk.PhotoImage(self.image2_1)
        self.photo2_2 = ImageTk.PhotoImage(self.image2_2)

        self.label1_1 = tk.Label(self.frame1, image=self.photo1_1)
        self.label1_1.grid(row=0, column=0, padx=10, pady=5)

        self.label1_2 = tk.Label(self.frame1, image=self.photo1_2)
        self.label1_2.grid(row=0, column=1, padx=10, pady=5)

        self.label2_1 = tk.Label(self.frame1, image=self.photo2_1)
        self.label2_1.grid(row=1, column=0, padx=10, pady=5)

        self.label2_2 = tk.Label(self.frame1, image=self.photo2_2)
        self.label2_2.grid(row=1, column=1, padx=10, pady=5)

        self.button_next = tk.Button(self.frame2, text="Next", command=self.next_images, width=18, height=2)
        self.button_next.grid(row=2, column=1, padx=10, pady=10)

    def next_images(self):
        self.index += 2

        if self.index >= len(self.files1) or self.index >= len(self.files2):
            return

        self.image1_path1 = os.path.join(dir1, self.files1[self.index+2])
        self.image1_path2 = os.path.join(dir1, self.files1[self.index + 3])
        self.image2_path1 = os.path.join(dir2, self.files2[self.index+2])
        self.image2_path2 = os.path.join(dir2, self.files2[self.index + 3])

        self.image1_1 = Image.open(self.image1_path1)
        self.image1_2 = Image.open(self.image1_path2)
        self.image2_1 = Image.open(self.image2_path1)
        self.image2_2 = Image.open(self.image2_path2)

        self.image1_1 = self.image1_1.resize((600, 340))
        self.image1_2 = self.image1_2.resize((600, 340))
        self.image2_1 = self.image2_1.resize((600, 340))
        self.image2_2 = self.image2_2.resize((600, 340))

        self.photo1_1 = ImageTk.PhotoImage(self.image1_1)
        self.photo1_2 = ImageTk.PhotoImage(self.image1_2)
        self.photo2_1 = ImageTk.PhotoImage(self.image2_1)
        self.photo2_2 = ImageTk.PhotoImage(self.image2_2)

        self.label1_1.configure(image=self.photo1_1)
        self.label1_2.configure(image=self.photo1_2)
        self.label2_1.configure(image=self.photo2_1)
        self.label2_2.configure(image=self.photo2_2)

    def run(self):
        self.root.mainloop()

# Example usage
dir1 = "/Users/cui_yutao/Desktop/Design_and_Build/TestImages"
dir2 = "/Users/cui_yutao/Desktop/Design_and_Build/runs/detect/predict"

app = ImageComparator(dir1, dir2)
app.run()